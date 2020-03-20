package API;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.util.Date;

public class Rate {
    @JsonProperty("Cur_ID")
    public int curID;
    @JsonProperty("Date")
    public Date date;
    @JsonProperty("Cur_Abbreviation")
    public String curAbbreviation;
    @JsonProperty("Cur_Scale")
    public int curScale;
    @JsonProperty("Cur_Name")
    public String curName;
    @JsonProperty("Cur_OfficialRate")
    public double curOfficialRate;

    @Override
    public String toString() {
        return curScale + " " + curAbbreviation + " - " + curOfficialRate + " BNR";
    }
}
