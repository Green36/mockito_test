package jp.k.green.myapplication;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SampleB.class)
public class SampleATestStatic extends TestCase{

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
        when(SampleB.getSample()).thenReturn(3);
        assertEquals( "aaa", SampleB.getSample());
    }


}