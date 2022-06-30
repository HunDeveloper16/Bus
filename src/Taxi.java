public class Taxi {

    int taxi_num=0;
    int fuel=0;

    int speed=0;

    int destination=0; // 목적지

    int distance=10; // 기본 거리

    int destination_distance=0; //목적지까지의 거리

    int fee=1000; //기본 요금

    int fee_per_distance=200; //거리+1당 요금

    int totalfee=0;

    String statement="on"; //운행중(take),일반(on)

    boolean start = false;

    public Taxi(int taxi_num){
        this.taxi_num = taxi_num;
    }

    public void start_Operation(){ //운행시작
        start = fuel >= 10 ? true : false; // 주유량이 10 이상이면 운행시작
    }

    public void take_Passenger(){

        if ( start == true ){
            if (statement=="on"){
                statement="take";  // 탑승 중 상태로 변경
            }
            else{
                System.out.print("탑승 불가");
            }
        }
        else{
            System.out.print("택시가 운행하지 않고 있습니다.");
        }
    }

    public void changeSpeed(int speed) {
        this.speed+=speed;
    }

    public void add_Fee_Per_Distance(int destination_distance){

        this.destination_distance = destination_distance;

        if(destination_distance > destination){
            totalfee=fee+fee_per_distance*(destination_distance-destination);
        }
    }

    public int payment(){
        return totalfee;
    }

    public boolean getStart(){
        return this.start;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String getStatement(){
        return this.statement;
    }


    public static void main(String[] args){

        Taxi taxi1 = new Taxi(1);
        taxi1.start_Operation();
        taxi1.changeSpeed(50);
        taxi1.add_Fee_Per_Distance(500);

        System.out.print("\n"+taxi1.taxi_num+"번 택시의 정보입니다."+"\n택시 출발 상태는? "+taxi1.getStart()+" \n현재 속도는: "+taxi1.getSpeed()+" \n승객 탑승여부는: "+ taxi1.getStatement()
                +"\n기본 거리 요금은? "+"기본 거리 "+taxi1.distance+"에 "+taxi1.fee+"원 입니다."
                +"\n추가 거리 요금은? "+"추가 거리당 "+taxi1.fee_per_distance+"원이 붙습니다."
                +"목적지의 거리는?"+taxi1.destination_distance+"\n"
                +"총 가격은?"+taxi1.payment());

    }

}
