package test;

public class fuck {
    public static void main(String[] args) {
        fuck f = new fuck();
        String s = f.changeFormatNumber("-1");
        System.out.println("s = " + s);
    }
    public String changeFormatNumber (String number) {
        // write code here
        StringBuilder build = new StringBuilder();
        long nu = Long.parseLong(number);
        for(int i=0;i<16;i++){
            long re = nu&1;
            build.insert(0,re);
            nu = nu >> 1;
        }
        nu = Long.parseLong(number);
        StringBuilder fuc = new StringBuilder();
        int de;
        build.append(",");
        for (de = 0; de < 16; de+=4) {
            int bu = 0;
            StringBuilder str = new StringBuilder(build.substring(de,de+4));
            if (str.charAt(0) == '1')
                bu += 8;
            if (str.charAt(1) == '1')
                bu += 4;
            if (str.charAt(2) == '1')
                bu += 2;
            if (str.charAt(3) == '1')
                bu += 1;
            switch(String.valueOf(bu)){
                case "15":
                    fuc.insert(0,"F");
                    break;
                case "14":
                    fuc.insert(0,"E");
                    break;
                case "13":
                    fuc.insert(0,"D");
                    break;
                case "12":
                    fuc.insert(0,"C");
                    break;
                case "11":
                    fuc.insert(0,"B");
                    break;
                case "10":
                    fuc.insert(0,"A");
                    break;
                default:
                    fuc.insert(0,String.valueOf(de));
            }
        }
        build.append(fuc.toString());
        return build.toString();
    }
}
