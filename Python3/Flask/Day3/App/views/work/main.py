from flask import Blueprint,render_template
from App.models import db,User,Record,RecordType

worker = Blueprint('worker',__name__)

@worker.route('/dballinit/')
def create_db():
  db.create_all();
  return '创建成功'


@worker.route('/dballdrop/')
def drop_db():
  db.drop_all()
  return '删除成功'

# 增
@worker.route('/userinsert/')
def insert_user():
  peoples = []

  for i in range(6):
    people = User()
    people.name = "测试人员%d" % i
    people.gender = 0 if i % 2 else 1
    people.yearsofwork = i
    people.address = "办公位置: 70{}".format(i)
    peoples.append(people)

  db.session.add_all(peoples)
  db.session.commit()

  return 'Insert User Successful!'

# 查
@worker.route('/userget/<int:id>')
def query_user(id):
  count = User.query.count()
  first = User.query.first()
  middle = User.query.get_or_404(3)
  custom = User.query.get(id)

  res1 =  User.query.filter_by(gender=0,yearsofwork=3).first()             # 简单条件过滤
  res2 = User.query.filter(User.name.startswith('测试人员')).limit(2).all() # 复杂条件过滤

  result = User.query.all()  # 返回该表的所有数据

  if middle != None:
    print("类型", type(count), " 总数据条数: " , count)
    print("类型", type(first), "第一行数据: ",first)
    print("类型", type(middle), "索引为3得数据(不存在则返回404): ", middle)
    print("类型", type(custom), "索引为 {} 得数据: ".format(id), custom)
    print("Index: {}, Name: {}, Gender: {}, Address: {} \n".format(custom.uid, custom.name, custom.gender, custom.address))

    print("\nquery.filter_by 类型: ",type(res1))
    print("Index: {}, Name: {}, Gender: {}, Address: {} \n".format(res1.uid, res1.name, res1.gender, res1.address))
    
    print("query.filter 类型 : ",type(res2))
    print("all 类型: \n",type(result))

    return render_template('User/query.html',title="User query",result=result)
  
  else:
    return 'Index not found!'

 
 # 删
@worker.route('/userdelete/')
def delete_query():
  obj = User.query.filter_by(name="测试人员5").first()
  db.session.delete(obj)
  db.session.commit()
  
  return "测试人员5 - Delete Success"


 # 改
@worker.route('/userupdate/')
def update_user():
  obj = User.query.filter_by(yearsofwork=3).first()
  obj.name = "WeiyiGeek"
  obj.address = "https://weiyigeek.top" 

  db.session.add(obj)
  db.session.commit();

  return '<script>alert("修改成功");location.href="/userget/"</script>'

# 更新所有的数据
@worker.route('/userallupdate/')
def update_all():
  obj = User.query.all()
  
  for i in obj:
    i.name = "WeiyiGeek's"

  db.session.add_all(obj)
  db.session.commit()

  return '<script>alert("修改成功");location.href="/userget/"</script>'
