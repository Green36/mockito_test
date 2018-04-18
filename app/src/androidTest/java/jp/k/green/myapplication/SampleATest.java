package jp.k.green.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SampleATest {

    @Test
    public void createName() {
        SampleA hoge = mock(SampleA.class);
        SampleB foo = new SampleB();
        when(hoge.createName()).thenReturn("aaa");
        assertEquals( "aaa", hoge.createName());
    }
}