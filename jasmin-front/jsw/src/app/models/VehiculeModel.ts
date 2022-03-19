import { AjouterParModel } from "./AjouterParModel";
import { JourneeBasicModel } from "./JourneeBasicModel";
import { VehiculeDetailModel } from "./VehiculeDetailModel";

export interface VehiculeModel{
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
    ajouterpar?: AjouterParModel;
    journee?: JourneeBasicModel
}