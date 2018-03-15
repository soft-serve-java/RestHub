import {Role} from "./role";

export class User {
  private id: number;
  private email: string;
  private password: string;
  private name: string;
  private confirmationtoken: boolean;
  private enabled: boolean;
  private roles: Role;
  private avatar: string;
}
