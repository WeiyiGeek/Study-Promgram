# 全局变量注册
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
    
# SQLALCHEMY 接收的环境变量定义在类中
# 开发环境
class DevelopConfig:
  DEBUG = True
  SQLALCHEMY_TRACK_MODIFICATIONS = False
  DBINFO = {
    "ENGINE": "sqlite",
    "NAME": "sqlite.db"
  }
  SQLALCHEMY_DATABASE_URI = get_db_uri(DBINFO)

# 生产环境
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


# 环境切换定义
envs = {
  "develop": DevelopConfig,
  "product": ProductConfig
}
