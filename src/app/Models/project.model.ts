import { User } from './user.model';

export interface Project {
  id: number;
  projectName: string;
  description: string;
  user: User;
}
