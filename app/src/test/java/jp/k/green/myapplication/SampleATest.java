package jp.k.green.myapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.powermock.api.mockito.PowerMockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SampleB.class, SampleA.class})
public class SampleATest {

    @Mock(name = "sampleB")
    private SampleB sampleBMock;

    @InjectMocks
    private SampleA sampleA = new SampleA();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

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