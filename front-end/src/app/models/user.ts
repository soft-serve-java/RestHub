import {Role} from "./role";

export class User {
  id: number;
  email: string;
  private password: string;
  name: string;
  confirmationtoken: boolean;
  enabled: boolean;
  role: Role[];
  avatar: string;
}
