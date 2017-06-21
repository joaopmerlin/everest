import {Model} from "./model";

export class User implements Model<number> {
  id: number;
  name: string;
  email: string;
  password: string;
}
