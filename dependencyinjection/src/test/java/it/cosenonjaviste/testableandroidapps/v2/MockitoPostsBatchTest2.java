package it.cosenonjaviste.testableandroidapps.v2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import it.cosenonjaviste.testableandroidapps.model.Post;
import it.cosenonjaviste.testableandroidapps.model.PostResponse;
import it.cosenonjaviste.testableandroidapps.model.WordPressService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoPostsBatchTest2 {

    @Mock WordPressService service;

    @Mock EmailSender sender;

    private PostBatch postBatch;

    @Before public void init() {
        postBatch = new PostBatch(service, sender);
    }

    @Test
    public void testExecute() {
        when(service.listPosts())
                .thenReturn(new PostResponse(new Post(), new Post(), new Post()));

        postBatch.execute();

        verify(sender, times(3)).sendEmail(any(Post.class));
    }
}
