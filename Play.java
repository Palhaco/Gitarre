import gdp.stdlib.*;

class Play {
    public static void main(String[] args) {
	/*
	double freq = 329;
	for (int i = 0; i < 44100; i++) {
	    StdAudio.play(0.5 * Math.sin(2*Math.PI * freq * i / 44100));
	    System.out.println(0.5 * Math.sin(2*Math.PI * freq * i / 44100));
	}
	*/
	while(true) {
	    /*
	    for(double i=0; i<=6.28; i+=0.05) {
		StdAudio.play(2 * Math.sin(i));
		System.out.print("\r"+i);
	    } 
	    */
	  
	    for(double i=0; i<=.05; i+=0.01) 
	    {
	    	StdAudio.play(.629 );
	    }
	}
    }
}