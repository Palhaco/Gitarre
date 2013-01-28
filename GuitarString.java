class GuitarString {
    GuitarString(double frequency) {}
    
    public void pluck()                       {}	// set the buffer to white noise
    public   void mute()                  {}	// fill the buffer with zeros
    public   void pressFretDown(int fret) {}	// change the length of the buffer according to the number of frets
    public   void tic()                   {}	// advance the simulation one time step
    public double sample()                { return 0; }	// return the current sample
    public    int time() {return 0;}	// return number of tics

}