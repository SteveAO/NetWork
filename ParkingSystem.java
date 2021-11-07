package Git;

import java.util.ArrayList;

public class ParkingSystem implements IParking{
    private int bigcar;
    private int mediumcar;
    private int smallcar;
    private ArrayList arrayList;
    boolean[] result;

    ParkingSystem(Integer big, Integer medium, Integer small){
        this.bigcar = big;
        this.mediumcar = medium;
        this.smallcar = small;
        arrayList = new ArrayList(big+medium+small);

    }

    public String[] parse(String input){
        String substring = input.substring(0, 7);
        String substring1 = input.substring(8, input.length());
        String[] split = substring1.split(",");
        String newstr[] = new String[split.length+1];
        newstr[0] = substring;
        for(int i=0;i< split.length;i++){
            newstr[i+1] = split[i];
        }
        result = new boolean[newstr.length-1];
        //[1,1,0]  [1]  [2],  [3]  [1]

        String substring2 = substring.substring(1, substring.length() - 1);
        String[] split1 = substring2.split(",");
        bigcar = Integer.parseInt(split1[0]);
        mediumcar = Integer.parseInt(split1[1]);
        smallcar = Integer.parseInt(split1[2]);
        int num = 1;
        while (num < newstr.length-1){
            String reastr = newstr[num];
            String reastrsub = reastr.substring(1, reastr.length() - 1);
            int nummber = Integer.parseInt(reastrsub);
            boolean b = addCar(nummber);
            result[num-1] = b;
            num++;
        }
        return newstr;
    }

    @Override
    public void print() {
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    @Override
    public boolean addCar(int carType) {
        if (carType <= 0 || carType > 3){
            throw new IndexOutOfBoundsException("输入的参数有误");
        }
        if(carType == 1 && carType <= smallcar){
            arrayList.add(carType);
            smallcar--;
            return true;
        }else if (carType == 2 && carType <= mediumcar){
            arrayList.add(carType);
            mediumcar--;
            return true;
        }else if (carType == 3 && carType <= bigcar){
            arrayList.add(carType);
            bigcar--;
            return true;
        }
        return false;
    }


}
