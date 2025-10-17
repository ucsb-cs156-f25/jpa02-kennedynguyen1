package edu.ucsb.cs156.spring.hello;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Kennedy N.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("kennedynguyen1", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f25-05", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("BRIAN PATRICK"),"Team should contain Brian Patrick");
        assertTrue(t.getMembers().contains("HECHENJIN"),"Team should contain Hechenjin");
        assertTrue(t.getMembers().contains("JASMINE"),"Team should contain Jasmine");
        assertTrue(t.getMembers().contains("KENNEDY"),"Team should contain Kennedy");
        assertTrue(t.getMembers().contains("MON RAPHAEL"),"Team should contain Mon Raphael");
        assertTrue(t.getMembers().contains("MELVIN ANTHONY"),"Team should contain Melvin Anthony");
    }
}


