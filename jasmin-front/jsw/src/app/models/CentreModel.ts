import { EmployeeModel } from "./EmployeeModel";
import { FormuleModel } from "./FormuleModel";

export interface CentreModel{
    id?: number;
    label?: string;
    ouverture?: Date;
    fermeture?: Date;
    adresse?: string;
    telephone?: string;
    code?: string;
    responsable?: EmployeeModel;
    formule?: FormuleModel;
    croissancemp?: number;
}