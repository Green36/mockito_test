package jp.k.green.myapplication;




import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.powermock.modules.junit4.legacy.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class SampleATest {

    @Mock(name = "sampleB")
    private SampleB sampleBMock;

    @InjectMocks
    private SampleA sampleA = new SampleA();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createName1() {
        when(sampleBMock.getName(1)).thenReturn("aaa");
        assertEquals( "aba", sampleA.createName());
    }

    @Test
    public void createName2() {
        SampleA hoge = mock(SampleA.class);
        when(hoge.createName()).thenReturn("aaa");
        assertEquals( "aaa", hoge.createName());
    }
}