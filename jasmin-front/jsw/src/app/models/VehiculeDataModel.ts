import { VehiculeDetailModel } from "./VehiculeDetailModel";

export interface VehiculeDataModel{
    id: number;
    prixfinale?: number;
    prixinitial?: number;
    remise?: number;
    tva?: number;
    categorie?: string;
    matricule?: string;
    marque?: string;
    telephone?: string;
    note?: string;
    detail?: VehiculeDetailModel;
}