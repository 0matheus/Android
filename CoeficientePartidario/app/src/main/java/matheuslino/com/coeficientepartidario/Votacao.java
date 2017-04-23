package matheuslino.com.coeficientepartidario;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mathe on 22/04/2017.
 */

public class Votacao implements Parcelable {

    private int vagas;
    private int votantes;
    private int brancos;
    private int nulos;
    private int votosP1;
    private int votosP2;
    private int votosP3;

    public Votacao(int vagas, int votantes, int brancos, int nulos, int votosP1, int votosP2, int votosP3) {
        this.vagas = vagas;
        this.votantes = votantes;
        this.brancos = brancos;
        this.nulos = nulos;
        this.votosP1 = votosP1;
        this.votosP2 = votosP2;
        this.votosP3 = votosP3;
    }

    public Votacao() {

    }

    protected Votacao(Parcel in) {
        vagas = in.readInt();
        votantes = in.readInt();
        brancos = in.readInt();
        nulos = in.readInt();
        votosP1 = in.readInt();
        votosP2 = in.readInt();
        votosP3 = in.readInt();
    }

    public static final Creator<Votacao> CREATOR = new Creator<Votacao>() {
        @Override
        public Votacao createFromParcel(Parcel in) {
            return new Votacao(in);
        }

        @Override
        public Votacao[] newArray(int size) {
            return new Votacao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(vagas);
        dest.writeInt(votantes);
        dest.writeInt(brancos);
        dest.writeInt(nulos);
        dest.writeInt(votosP1);
        dest.writeInt(votosP2);
        dest.writeInt(votosP3);
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getVotantes() {
        return votantes;
    }

    public void setVotantes(int votantes) {
        this.votantes = votantes;
    }

    public int getBrancos() {
        return brancos;
    }

    public void setBrancos(int brancos) {
        this.brancos = brancos;
    }

    public int getNulos() {
        return nulos;
    }

    public void setNulos(int nulos) {
        this.nulos = nulos;
    }

    public int getVotosP1() {
        return votosP1;
    }

    public void setVotosP1(int votosP1) {
        this.votosP1 = votosP1;
    }

    public int getVotosP2() {
        return votosP2;
    }

    public void setVotosP2(int votosP2) {
        this.votosP2 = votosP2;
    }

    public int getVotosP3() {
        return votosP3;
    }

    public void setVotosP3(int votosP3) {
        this.votosP3 = votosP3;
    }

}
