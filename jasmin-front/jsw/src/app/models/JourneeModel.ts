import { VehiculeModel } from './VehiculeModel';
import { CentreBasicModel } from './CentreBasicModel';
export interface JourneeModel{
    id?: number;
    centre?: CentreBasicModel;
    date?: Date;
    prixTTC?: number;
    prixHT?: number;
    vehicules?: VehiculeModel[];
}