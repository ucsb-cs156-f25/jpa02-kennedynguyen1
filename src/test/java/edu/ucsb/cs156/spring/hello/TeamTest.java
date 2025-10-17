package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_team() {
        Team t = new Team("test-team");
        assert(team.equals(t));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        Object o = new Object();
        assert(!team.equals(o));
    }

    @Test
    public void test_equals_same_name_and_members() {
        Team t1 = new Team("test-team");
        t1.addMember("Kennedy");
        Team t2 = new Team("test-team");
        t2.addMember("Kennedy");
        assert(t1.equals(t2));
    }

    @Test
    public void test_equals_same_name_different_members() {
        Team t1 = new Team("test-team");
        t1.addMember("Kennedy");
        Team t2 = new Team("test-team");
        t2.addMember("Not Kennedy");
        assert(!t1.equals(t2));
    }

    @Test
    public void test_equals_different_name() {
        Team t1 = new Team("team1");
        t1.addMember("Kennedy");
        Team t2 = new Team("team2");
        t2.addMember("Kennedy");
        assert(!t1.equals(t2));
    }

    @Test
    public void test_hashCode_same_name_and_members() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void test_equals_same_object() {
        Team t = new Team("test-team");
        assert(t.equals(t));
    }

    @Test
    public void test_hashCode_value() {
        Team t = new Team("test-team");
        t.addMember("member1");
        int result = t.hashCode();
        int expectedResult = -1091638530;
        assertEquals(expectedResult, result);
    }
}
