export class UserModel {
  id: string;
  login: string;
  password: string;
  balance: string;

static cloneBase (userModel: UserModel): UserModel {
  let clonedUserModel: UserModel = new UserModel();
  clonedUserModel.id = userModel.id;
  clonedUserModel.login = userModel.login;
  clonedUserModel.password = userModel.password;
  clonedUserModel.balance = userModel.balance;

  return clonedUserModel;
  }
}
