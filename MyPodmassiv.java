public class MyPodmassiv {

    private int [] mass;

    MyPodmassiv(int [] input_mass) {
        mass = new int [input_mass.length];
        for (int i=0; i<input_mass.length; i++)
        mass[i] = input_mass[i];
    }

    public int [] recurrentSearchWithLog() {
        // Массив А - самый большой вообще,
        // B - самый большой справа
        int indAleft = 0;
        int indAright = 0;
        int summA = mass[0]; if (summA < 0) summA = 0;
        int neSchitaliBRaz = 0;

        for (int i = 0; i < mass.length; i++) {
            System.out.println("i = " + i + ")");

            // В пересчитать, если новый эл-т > 0
            if (mass[i]>0) {
                int indTempLeft = 0;
                int tempSumm = 0;
                int tempMaxSumm = 0;

                // Достаточно дойти до конца подмассива А
                for (int j = i; j >= indAright; j--) {
                    if (j==indAright){
                        // Можно перепрыгнуть в начало А, т.к. он уже просчитан
                        tempSumm += summA;
                        j = indAleft;
                        System.out.println("Прыжок в начало А, сумма " + tempSumm);
                    } else{
                        tempSumm += mass[j];
                        System.out.println("Шаг j " + j + ": сумма " + tempSumm + ", слагаемое " + mass[j]);
                    }

                    if (tempSumm > tempMaxSumm) {
                        tempMaxSumm = tempSumm;
                        indTempLeft = j;
                        System.out.println("Заменили j на " + j);
                    }
                }
                System.out.println("Сумма В равна: " + tempMaxSumm + " (" + indTempLeft + "..)");

                if (tempMaxSumm >= summA) {
                    summA = tempMaxSumm;
                    indAleft = indTempLeft;
                    indAright = i;
                    System.out.println("Сумма А изменена, теперь " + summA + " (" + indAleft + ".." + indAright + ")");
                } else
                    System.out.println("A не меняется (просто сумма В не больше): A = " + summA + " (" + indAleft + ".." + indAright + ")");

            } else {
                System.out.println("Попался эл-т =< 0, В не пересчитывать.\nA не меняется: A = " + summA + " (" + indAleft + ".." + indAright + ")");
                neSchitaliBRaz++;
            }
        }

        System.out.println("Сумма вышла: " + summA);
        System.out.println("Не пришлось пересчитывать В " + neSchitaliBRaz + " раз");

        int [] otvet = new int [indAright - indAleft + 1];
        int temp = 0;
        for (int i=indAleft; i<=indAright; i++) {
            otvet[temp] = mass[i];
            temp++;
        }
        return otvet;
    }

    public int [] recurrentSearch() {
        int indAleft = 0;
        int indAright = 0;
        int summA = mass[0]; if (summA < 0) summA = 0;

        for (int i = 0; i < mass.length; i++) {
            if (mass[i]>0) {
                int indTempLeft = 0;
                int tempSumm = 0;
                int tempMaxSumm = 0;

                for (int j = i; j >= indAright; j--) {
                    if (j==indAright){
                        tempSumm += summA;
                        j = indAleft;
                    } else tempSumm += mass[j];

                    if (tempSumm > tempMaxSumm) {
                        tempMaxSumm = tempSumm;
                        indTempLeft = j;
                    }
                }

                if (tempMaxSumm >= summA) {
                    summA = tempMaxSumm;
                    indAleft = indTempLeft;
                    indAright = i;
                }
            }
        }

        int [] otvet = new int [indAright - indAleft + 1];
        int temp = 0;
        for (int i=indAleft; i<=indAright; i++) {
            otvet[temp] = mass[i];
            temp++;
        }
        return otvet;
    }

    public int [] poiskVlob(){
        int indTempRight = 0;
        int indTempLeft = 0;
        int tempSumm = 0;
        int maxSumm = 0;

        for (int i = 0; i < mass.length; i++) {
            for (int j = i; j < mass.length; j++) {
                tempSumm += mass[j];
                if (tempSumm > maxSumm) {
                    maxSumm = tempSumm;
                    indTempRight = j;
                    indTempLeft = i;
                }
            }
            tempSumm = 0;
        }

        int [] otvet = new int [indTempRight - indTempLeft + 1];
        int temp = 0;
        for (int i=indTempLeft; i<=indTempRight; i++) {
            otvet[temp] = mass[i];
            temp++;
        }
        return otvet;
    }
}
