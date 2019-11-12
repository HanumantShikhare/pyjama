package org.h_shikhare.pyjama.string;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PyStringTest {

    @Test
    public void capitalize() {
        assertNull(PyString.capitalize(null));
        assertEquals("", PyString.capitalize(""));
        assertEquals("S", PyString.capitalize("s"));
        assertEquals("Simple", PyString.capitalize("simple"));
        assertEquals("Simple", PyString.capitalize("SIMPLE"));
        assertEquals("Simple", PyString.capitalize("SIMPLE"));
        assertEquals("            ss", PyString.capitalize("            ss"));
    }

    @Test
    public void center() {
        assertNull(PyString.center(null, 9, ' '));
        assertEquals("abc", PyString.center("abc", 3, ' '));
        assertEquals("abcd", PyString.center("abcd", 2, ' '));
        assertEquals("  A  ", PyString.center("A", 5, ' '));
        assertEquals(" asdasdasd  ", PyString.center("asdasdasd", 12, ' '));
        assertEquals("*asdasdasd**", PyString.center("asdasdasd", 12, '*'));

        assertNull(PyString.center(null, -1, ' '));
        assertNull(PyString.center(null, 4, ' '));
        assertEquals("    ", PyString.center("", 4, ' '));
        assertEquals("ab", PyString.center("ab", 0, ' '));
        assertEquals("ab", PyString.center("ab", -1, ' '));
        assertEquals("ab", PyString.center("ab", 1, ' '));
        assertEquals("    ", PyString.center("", 4, ' '));
        assertEquals(" ab ", PyString.center("ab", 4, ' '));
        assertEquals("abcd", PyString.center("abcd", 2, ' '));
        assertEquals(" a  ", PyString.center("a", 4, ' '));
        assertEquals("  a  ", PyString.center("a", 5, ' '));
        assertEquals("xxaxx", PyString.center("a", 5, 'x'));
    }

    @Test
    public void count() {
        assertEquals(0, PyString.count(null, null));
        assertEquals(0, PyString.count("", null, -1));
        assertEquals(0, PyString.count(null, "", -1, -1));
        assertEquals(0, PyString.count(null, null, -1, -1));

        assertEquals(1, PyString.count("ab", "ab"));

        assertEquals(0, PyString.count(null, null));
        assertEquals(0, PyString.count("blah", null));
        assertEquals(0, PyString.count(null, "DD"));

        assertEquals(0, PyString.count("x", ""));
        assertEquals(0, PyString.count("", ""));

        assertEquals(3, PyString.count("one long someone sentence of one", "one"));
        assertEquals(0, PyString.count("one long someone sentence of one", "two"));
        assertEquals(4, PyString.count("oooooooooooo", "ooo"));
        assertEquals(5, PyString.count("oooooooooooo    ooo", "ooo"));
    }
}