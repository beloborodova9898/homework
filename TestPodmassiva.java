import org.junit.Assert;
import org.junit.Test;

public class TestPodmassiva {
    @Test
    public void testEquals2Metoda() {
        int mass_n = 20;
        int skok_raz_test = 15;
        int max_random_cifra = 50;

        for (int prohod=0; prohod < skok_raz_test; prohod++) {
            int[] inpMass = new int[mass_n];
            for (int i=0; i<mass_n; i++)
                inpMass[i] = (int) ((Math.random() * (max_random_cifra*2)) - max_random_cifra);
            MyPodmassiv testoviy = new MyPodmassiv(inpMass);

            int [] otvetOtF1 = testoviy.recurrentSearch();
            int [] otvetOtF2 = testoviy.poiskVlob();

            int summOtF1 = summPodmassiva(otvetOtF1);
            int summOtF2 = summPodmassiva(otvetOtF2);

            Assert.assertEquals(summOtF1, summOtF2);
        }
    }

    private int summPodmassiva (int [] massiv) {
        int otvet =0;
        for (int i=0; i<massiv.length; i++)
            otvet+=massiv[i];
        return otvet;
    }
}
