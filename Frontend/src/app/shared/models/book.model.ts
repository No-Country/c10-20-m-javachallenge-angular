import { Category } from "./category.model";

export interface Book {
  id?: number;
  category: Category;
  title: string;
  author: string;
  isbn: string;
  publisherHouse: string;
  yearOfPublication: number;
  availability: boolean;
  summary: string;
}
