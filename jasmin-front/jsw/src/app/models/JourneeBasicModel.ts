import { CentreBasicModel } from "./CentreBasicModel";

export interface JourneeBasicModel{
    id?: number;
    centre?: CentreBasicModel;
    date?: Date;
    prixTTC?: number;
    prixHT?: number;
}