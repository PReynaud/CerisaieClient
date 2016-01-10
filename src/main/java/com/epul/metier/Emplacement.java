package com.epul.metier;

/**
 * Created by Laura on 10/01/2016.
 */
public class Emplacement {


        private int numEmpl;
        private int codeTypeE;
        private float surfaceEmpl;
        private int nbPersMaxEmpl;

    public Emplacement(int numEmpl, int codeTypeE, float surfaceEmpl, int nbPersMaxEmpl) {
        this.numEmpl = numEmpl;
        this.codeTypeE = codeTypeE;
        this.surfaceEmpl = surfaceEmpl;
        this.nbPersMaxEmpl = nbPersMaxEmpl;
    }

    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
    }

    public int getCodeTypeE() {
        return codeTypeE;
    }

    public void setCodeTypeE(int codeTypeE) {
        this.codeTypeE = codeTypeE;
    }

    public float getSurfaceEmpl() {
        return surfaceEmpl;
    }

    public void setSurfaceEmpl(float surfaceEmpl) {
        this.surfaceEmpl = surfaceEmpl;
    }

    public int getNbPersMaxEmpl() {
        return nbPersMaxEmpl;
    }

    public void setNbPersMaxEmpl(int nbPersMaxEmpl) {
        this.nbPersMaxEmpl = nbPersMaxEmpl;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Emplacement that = (Emplacement) o;

            return numEmpl == that.numEmpl && codeTypeE == that.codeTypeE &&
                    Float.compare(that.surfaceEmpl, surfaceEmpl) == 0 &&
                    nbPersMaxEmpl == that.nbPersMaxEmpl;

        }

        @Override
        public int hashCode() {
            int result = numEmpl;
            result = 31 * result + codeTypeE;
            result = 31 * result + (surfaceEmpl != +0.0f ? Float.floatToIntBits(surfaceEmpl) : 0);
            result = 31 * result + nbPersMaxEmpl;
            return result;
        }
    }



