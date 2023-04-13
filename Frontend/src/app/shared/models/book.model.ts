export interface Book {
  id?: number;
  idCategory: number;
  title: string;
  author: string;
  isbn: string;
  publisherHouse: string;
  yearOfPublication: number;
  availability: boolean;
  summary: string;
}
