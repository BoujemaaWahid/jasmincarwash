import { VehiculeDataModel } from './VehiculeDataModel';
import { CentreBasicModel } from "./CentreBasicModel";

export interface EmployeeModel{
    id?: number;
    active?: boolean;
    prenom?: string;
    nom?: string;
    type?: string;
    telephone?: string;
    email?: string;
    assume ?: CentreBasicModel[];
    vehicules ?: VehiculeDataModel[];
}