/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoShotMyPos;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class solarSystemData {
    private final HashMap<Integer, String> solarSystems = new HashMap();
    
    public solarSystemData(){
        loadSolarSystemData();
    }
    
    private void loadSolarSystemData(){
        InputStream in = this.getClass().getResourceAsStream("/data/SolarSystemIDs.txt");
        try (Scanner scan = new Scanner(in)) {        
            while((scan.hasNextLine())){
                String[] solarSystemInformation = scan.nextLine().split("\t");
                String systemName = solarSystemInformation[1];
                int systemID = Integer.parseInt(solarSystemInformation[0]);
                solarSystems.put(systemID, systemName);
            }
            
        }       
    }
    
    public String getSystemName(int solarSystemID){
        return solarSystems.get(solarSystemID);
    }
    
}
