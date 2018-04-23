package jp.k.green.myapplication;

import android.app.Activity;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.internal.configuration.PowerMockitoInjectingAnnotationEngine;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.robolectric.Shadows.shadowOf;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class ,sdk = (Build.VERSION_CODES.LOLLIPOP))
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*" })
@PrepareForTest({SampleB.class, SampleA.class})

//@RunWith(PowerMockRunner.class)
//@PowerMockRunnerDelegate(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class, sdk = 21)
//@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
//@PrepareForTest({SampleB.class, SampleA.class})
public class SampleATest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();


    @Mock(name = "sampleB")
    private SampleB sampleBMock;

    @InjectMocks
    private SampleA sampleA = new SampleA();

    @Before
    public void setup() {
//        MockitoAnnotations.initMocks(this);
    }


//    private TextView mText;
//    private Button mButton;

//    @Before
//    public void setUp() {
//        // viewの取得
//        Activity activity = Robolectric.setupActivity(MainActivity.class);
//        mText = (TextView) activity.findViewById(R.id.text);
//        mButton = (Button) activity.findViewById(R.id.button);
//    }
//
//    @Test
//    public void trueNextActivity() {
//        // ボタンのclick(別のアクティビティに遷移させるようにしていた場合）
//        mButton.performClick();
//
//        // 遷移先のActivityがあるか
//        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
//        assertThat("Next activity has started", application.getNextStartedActivity(), is(notNullValue()));
//    }

    /**
     * basic
     */
    @Test
    public void createName1() {
        SampleA hoge = PowerMockito.mock(SampleA.class);
        PowerMockito.when(hoge.createName()).thenReturn("aaa");
        assertEquals( "aaa", hoge.createName());
    }

    /**
     * normal test
     */
    @Test
    public void createName2() {
        sampleBMock = Mockito.mock(SampleB.class);
        Mockito.when(sampleBMock.getName(1)).thenReturn("aaa");
        assertEquals( "aaa", sampleA.createName());
    }

    /**
     * static method test
     */
    @Test
    public void createName3() {
        PowerMockito.mockStatic(SampleB.class);
        Mockito.when(SampleB.getSample()).thenReturn(3);

        SampleA a = new SampleA();
        assertEquals( "other", a.createName());
    }
}