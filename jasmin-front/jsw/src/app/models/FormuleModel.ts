import { CentreBasicModel } from "./CentreBasicModel";
import { PrixModel } from "./PrixModel";

export interface FormuleModel{
    id?: number;
    label?: string;
    centres?: CentreBasicModel[];
    citadine?: PrixModel[];
    berline?: PrixModel[];
    monospace?: PrixModel[];
    moto?: PrixModel[];
}