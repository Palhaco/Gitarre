class Guitar{
    /** Variablen */
    private final int SAITENANZAHL = 6;
    private GuitarString[] saiten;
	
    /**
     * Konstruktor
     */
    Guitar(){
	// Saiten intialisieren
	this.saiten    = new GuitarString[SAITENANZAHL];
	this.saiten[0] = new GuitarString(329.63);
	this.saiten[1] = new GuitarString(246.94);
	this.saiten[2] = new GuitarString(196);
	this.saiten[3] = new GuitarString(146.83);
	this.saiten[4] = new GuitarString(110);
	this.saiten[5] = new GuitarString(82.41);
    }
    /**
     * Eine Saite anzupfen
     * @param string Die Seite die angezupft werden soll. 
     *               Erst Saite ist 0.
     */
    public void pluckString(int string){
	this.saiten[string].pluck();
    }

    /**
     * Gitarre stumm schalten
     */
    public void mute() {
	for(GuitarString saite:this.saiten) {
	    saite.mute();
	}
    }

    /**
     * Tonhoehe einer Saite bestimmen.
     * @param string Die Seite auf der die Tonhoehe geaendert werden soll.
     * @param fret Der Bund auf den gedrueckt werden soll.
     */
    public void pressFretDown(int string, int fret) {
	this.saiten[string].pressFretDown(fret);
    }

    /**
     * Simluation auf allen Seiten einen Schritt 
     * weiter.
     */
    public void tic() {
	for(GuitarString saite:this.saiten) {
	    saite.tic();
	}
    }


    /**
     * Den Ton von der Guitarre abnehmen, der entsteht
     * wenn alle Saiten klingeln (evtl. nicht alle). 
     * @return Die Frequenz aller angeschlagener Saiten.
     */
    public double sample() {
	double sample = 0;
	for(GuitarString saite:this.saiten) {
	    sample += saite.sample();
	}

	return sample;
    }
}
