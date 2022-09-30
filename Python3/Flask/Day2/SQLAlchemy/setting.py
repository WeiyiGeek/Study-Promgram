# 第三方库所需参数设置
# def init_param(app):
# # 数据库连接字符串通用: 数据库+驱动://用户名:密码@主机:端口/具体库?参数
#   app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///sqlite.db"
#   app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False


def get_db_uri(dbinfo):
  engine = dbinfo.get("ENGINE") or "sqlite"
  driver = dbinfo.get("DRIVER") or "sqlite"
  user = dbinfo.get("USER") or ""
  password = dbinfo.get("PASSWORD") or ""
  host = dbinfo.get("HOST") or ""
  port = dbinfo.get("PORT") or ""
  name = dbinfo.get("NAME") or ""

  if engine == "sqlite":
    return "{}:///{}".format(engine,name)
  else:
    return "{}+{}://{}:{}@{}:{}/{}".format(engine,driver,user,password,host,port,name)
    
    
class DevelopConfig:
  # SQLALCHEMY 接收的环境变量
  DEBUG = True
  SQLALCHEMY_TRACK_MODIFICATIONS = False
  DBINFO = {
    "ENGINE": "sqlite",
    "NAME": "sqlite.db"
  }
  SQLALCHEMY_DATABASE_URI = get_db_uri(DBINFO)


class ProductConfig:
  DEBUG = False
  SQLALCHEMY_TRACK_MODIFICATIONS = False
  DBINFO = {
    "ENGINE": "mysql",
    "DRIVER": "pymysql",
    "USER": "root",
    "PASSWORD": "weiyigeek#password",
    "HOST": "10.20.172.241",
    "PORT": "3306",
    "NAME": "FlaskTest"
  }
  SQLALCHEMY_DATABASE_URI = get_db_uri(DBINFO)


envs = {
  "develop": DevelopConfig,
  "product": ProductConfig
}


# def init_param(app):
# # 数据库连接字符串通用: 数据库+驱动://用户名:密码@主机:端口/具体库?参数
#   devconfig = DevelopConfig.DBINFO
#   proconfig = ProductConfig.DBURI
#   app.config['SQLALCHEMY_DATABASE_URI'] = proconfig
#   app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
