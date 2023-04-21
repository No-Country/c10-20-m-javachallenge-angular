export interface JWTResponse {
  token: string;
  email: string;
  authorities: [{ authority: string }];
  token_HEADER: string;
}
