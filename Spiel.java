import ea.*;

/**
 * Dieses Beispiel demonstriert, wie man die Funktionen der 
 * Kamera nutzen kann.
 * @version 2.0
 * @author Michael Andonie
 */
public class Spiel
extends Game {
    
    /**
     * Der 'Spieler'
     */
    private Kreis spieler;
    
    /**
     * Der einfache Hintergrund
     */
    private Rechteck hintergrund;
    
    /**
     * Konstruktor-Methode.<br />
     * Diese Methode richtet die beiden Grafiken ein.<br />
     * Die Kamera wird hierbei jedoch NICHT eingestellt.
     */
    public Spiel() {
        super(500, 400,"Kamera-Beispiel");
        
        //Hintergrund einstellen und sichtbar machen
        hintergrund = new Rechteck(-100, -100, 600, 500);
        hintergrund.farbeSetzen("Blau");
        wurzel.add(hintergrund);
        
        //Zur besseren Orientierung werden zusaetzlich einfache Rechtecke eingefuegt
        //So kann man immer mitkriegen, ob sich die Kamera oder der Kreis bewegt.
        Rechteck r1 = new Rechteck(0, 20, 50, 10);
        Rechteck r2 = new Rechteck(200, 300, 100, 40);
        wurzel.add(r1);
        wurzel.add(r2);
        
        //Spieler einstellen und sichtbar machen
        spieler = new Kreis(200, 200, 100);
        spieler.farbeSetzen("Rot");
        wurzel.add(spieler);
    }
    
    /**
     * Diese Methode sorgt dafuer, das ab sofort der Kreis im <i>Fokus</i>
     * der Kamera liegt.<br />
     * Als Parameter der Methode <code>fokusSetzen</code> in der Kamera wird 
     * ein beliebiges <code>Raum</code>-Objekt verlangt. Man kann also ein beliebiges 
     * anderes grafisches Objekt hier einsetzen!
     */
    public void fokusMachen() {
        //Den 'Spieler' als Fokus bei der Kamera setzen
        cam.fokusSetzen(spieler);
    }
    
    /**
     * Diese Methode setzt die Grenzen der Kamera so, dass die Kamera immer exakt
     * innerhalb des Hintergrundes bleibt.<br />
     * Um die Masse des Hintergrundes exakt zu erhalten, wird die Methode <code>dimension()</code> aus 
     * der Klasse Raum verwendet. Sollte diese nicht mehr bekannt sein, ist es empfehlenswert, das 
     * Kapitel 'Raum' im Handbuch nachzuschlagen!
     */
    public void kameraEingrenzen() {
        //Das Bounding-Rechteck, das die Grenzen der Kamera festlegt ist
        //genau das, was den Hitnergrund voll einschliesst.
        // ==> dimension() - Methode (siehe Kapitel 'Raum')
        BoundingRechteck grenzen = hintergrund.dimension();
        cam.boundsSetzen(grenzen);
    }
    
    /**
     * Taste-Reagieren-Methode.<br />
     * Hierdrin wird auf den Tasten W/A/S/D der Kreis als Spielfigur bewegt. Auf 
     * den Pfeiltasten wird die Kamera bewegt.<br /><br />
     * 
     * <b>ACHTUNG</b><br />
     * Auch wenn die Methode fuer die Kamera und <code>Raum</code>-Objekte <code>verschieben</code> 
     * heisst, leitet sich die Klasse Kamera <b>nicht</b> aus <code>Raum</code> ab!
     */
    @Override
    public void tasteReagieren(int tastencode) {
        switch(tastencode) {
            
            /* Verschieben des Kreises */
            
            case 0: //A - nach links
                spieler.verschieben(-10, 0);
                break;
            case 3: //D - rechts
                spieler.verschieben(10, 0);
                break;
            case 18: //S - unten
                spieler.verschieben(0, 10);
                break;
            case 22: //W - oben
                spieler.verschieben(0, -10);
                break;
                
            /* Verschieben der Kamera */
                
            case 26: //Pfeiltaste oben
                cam.verschieben(0, -10);
                break;
            case 27: //Pfeiltaste rechts
                cam.verschieben(10, 0);
                break;
            case 28: //Pfeiltaste unten
                cam.verschieben(0, 10);
                break;
            case 29: //Pfeiltaste links
                cam.verschieben(-10, 0);
                break;
        }
    }
}