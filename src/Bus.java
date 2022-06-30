public class Bus {
    int max_passenger = 10; //최대 승객수
    int take_passenger = 0; //현재 승객수

    int fee = 0;  //요금
    int bus_num = 0; //버스 번호
    int fuel = 0; //주유량
    int speed = 0; //현재 속도
    String statement = "on"; //상태(운행(on),차고지행(off))
    public Bus(int bus_num, int fuel){  //객체 생성시 고유값의 버스 번호,연료 생성
        this.bus_num=bus_num;
        this.fuel=fuel;
    }
    public void changeBus_Statement() {  // 버스 상태 변경
        this.statement = "off";
        if (fuel < 10) {
            System.out.print("주유가 필요합니다");
        }
    }
    public String getStatement(){
        return this.statement;
    }
    public void take_Passenger(int take_passenger) { // 승객 탑승
        if (this.statement=="on") {
            this.take_passenger = this.take_passenger+take_passenger >= max_passenger ? max_passenger : (this.take_passenger+take_passenger); //승객 탑승은 '최대 승객수'이하까지 가능
        }
        else{
            System.out.print("버스가 운행중이지 않습니다");
        }
    }

    public int getTake_Passenger() {
        return this.take_passenger;
    }

    public void changeSpeed(int speed) {
        if (fuel >= 10) {
            this.speed += speed;
        }
        else{
            System.out.print("주유량을 확인해주세요");
        }
    }
    public int getSpeed(){
        return this.speed;
    }

    public static void main(String[] args){

        Bus bus1 = new Bus(1,5); // 1: 주유량이 10미만인 차고지행 1번 버스
        bus1.changeSpeed(20);
        bus1.changeBus_Statement();
        bus1.take_Passenger(5);
        System.out.print("\n"+bus1.bus_num+"번 버스의 정보입니다."+"\n버스 상태는? "+bus1.getStatement()+" \n현재 속도는: "+bus1.getSpeed()+" \n현재 사람수는: "+ bus1.getTake_Passenger()+"\n");

        Bus bus2 = new Bus(2, 12); // 2: 주유량이 10이상인 운행중인 버스 , 승객수가 최대 승객수 미만일 때
        bus2.changeSpeed(20);
        bus2.take_Passenger(5);
        System.out.print("\n"+bus2.bus_num+"번 버스의 정보입니다."+"\n버스 상태는? "+bus2.getStatement()+" \n현재 속도는: "+bus2.getSpeed()+" \n현재 사람수는: "+ bus2.getTake_Passenger()+"\n"+"\n");

        Bus bus3 = new Bus(3, 5); // 3: 주유량이 10미만인 운행중인 버스, 승객수가 최대 승객수 초과했을 때
        bus3.changeSpeed(20);
        bus3.take_Passenger(15);
        System.out.print("\n"+bus3.bus_num+"번 버스의 정보입니다."+"\n버스 상태는? "+bus3.getStatement()+" \n현재 속도는: "+bus3.getSpeed()+" \n현재 사람수는: "+ bus3.getTake_Passenger());

    }

}




