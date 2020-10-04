package com.exampel;

public class cars {
        // Instansvariabler för hastighet, liter per mil och färg
        private String literMil;
        private String farg;
        private String hastighet;
        private String modelYear;
        private String framBak;

        // Konstruktor
        public cars(String literMil, String farg, String hastighet, String modelYear, String framBak) {
            this.literMil = literMil;
            this.farg = farg;
            this.hastighet = hastighet;
            this.modelYear = modelYear;
            this.framBak = framBak;
        }

        // Metod som returnerar hastighet
        public String getHastighet() {
            return hastighet;
        }

        public String getFrambak(){
            return framBak;
        }


        // En metod som skapar innehållet för bilen
        public String bilInfo(String namn) {
            String text = "Din " + namn + "\nHastighet: " + hastighet + " km/h.\nLiter per mil: " + literMil + "\nFärg: " + farg + "\nÅrsmodel: " + modelYear + "\n vilket håll bilen åker: " + framBak;
            return text;
        }

}

