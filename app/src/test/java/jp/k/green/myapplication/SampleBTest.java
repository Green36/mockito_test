package jp.k.green.myapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SampleBTest {

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
        assertEquals( "aaa", sampleA.createName());
    }

    @Test
    public void createName2() {
        SampleA hoge = mock(SampleA.class);
        when(hoge.createName()).thenReturn("aaa");
        assertEquals( "aaa", hoge.createName());
    }
}
