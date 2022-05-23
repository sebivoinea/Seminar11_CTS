package teste;

import clase.Persoana;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGetVarsta {

    @Test
    public void testRight() {
        Persoana persoana = new Persoana("Andrei", "5000328030013");
        assertEquals(22, persoana.getVarsta());
    }

    @Test
    public void testBoundaryInferior() {
        Persoana persoana = new Persoana("Ana", "3000101202324");
        assertEquals(222, persoana.getVarsta());
    }

    @Test
    public void testBoundarySuperior() {
        Persoana persoana = new Persoana("Ana", "6220202994719");
        assertEquals(0, persoana.getVarsta());
    }

    @Test(expected = CNPInvalidException.class)
    public void testVarstaInvalida() {
        Persoana persoana = new Persoana("Ana", "62500202222324");
        persoana.getVarsta();
    }

    //
//    @Test(expected=NumberFormatException.class)
//    public void errorAlfanumericGetVarsta() {
//        Persoana persoana1=new Persoana("Ana","6AA00202222324");
//        persoana1.getVarsta();
//    }
//
    @Test(timeout = 100)
    public void performanceTest() {
        Persoana persoana = new Persoana("Ana", "6210101832212");
        persoana.getVarsta();
    }

    @Test
    public void testGetVarstaConformance() {
        Persoana persoana = new Persoana("Ana", "6210101832212");
        assertTrue(persoana.getVarsta() >= 0);
    }

    @Test
    public void orderGetVarsta() {
        Persoana persoana1 = new Persoana("Ana", "1980202222324");
        Persoana persoana2 = new Persoana("Ion", "5020202222324");
        assertTrue(persoana1.getVarsta() > persoana2.getVarsta());
    }

    @Test(expected = NullPointerException.class)
    public void testGetVarstaExistance() {
        Persoana persoana = new Persoana("Ana", null);
        persoana.getVarsta();
    }
}
