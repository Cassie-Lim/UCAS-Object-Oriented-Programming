# Assignment 2

2020K8009915008 林孟颖

> 下述两个设计皆可编译运行，验证程序功能

## 1.图书馆借还书设计概述

### 1.1 学生类（Student）

- **属性**：
  - `name` (String) - 学生姓名
  - `student_id` (int) - 学号
  - `borrowed_books` (ArrayList<Book>) - 已借书列表
- **方法**：
  - `borrow_book(book: Book) : void` - 将书籍添加到已借书列表中。
  - `return_book(book: Book) : void` - 从已借书列表中移除书籍。
  - `get_borrowed_books() : ArrayList<Book>` - 返回已借书列表。

### 1.2 书籍类（Book）：

- **属性**：
  - `title` (String) - 书名
  - `author` (String) - 作者
  - `isbn` (String) - ISBN
  - `borrowed` (boolean) - 是否被借出
- **方法**：
  - `borrow() : void` - 将 `borrowed` 属性设为 True。
  - `return_book() : void` - 将 `borrowed` 属性设为 False。

### 1.3 管理员类（Librarian）：

- **属性**：
  - `name` (String) - 管理员姓名
  - `employee_id` (String) - 员工号
- **方法**：
  - `add_book(book: Book) : void` - 将书籍添加到图书馆的书库中。
  - `remove_book(book: Book) : void` - 将书籍从图书馆的书库中移除。

### 1.4 图书馆系统（LibrarySystem）：

- **属性**：
  - `librarian` (Librarian) - 图书馆管理员
  - `students` (ArrayList<Student>) - 已注册学生列表
  - `books` (ArrayList<Book>) - 所有书籍列表 (初始化为 `bookA--bookZ`)
- **方法**：
  - `main() : void` - 主函数入口
  - `find_book(title: String) : Book` - 查找书籍
  - `find_student(studentName: String) : Student` - 查找学生



## 2.  汽车类设计

### 2.1 厂家类 (Manufacturer)

- 属性：
  - `name` (String) - 厂家名称
  - `country` (String) - 所在国家
- 方法：
  - `getName() : String` - 获取厂家名称
  - `getCountry() : String` - 获取所在国家
  - `produceCar(model: String, color: String, year: int) : Car` - 生产一辆新车

### 2.2 车主类 (CarOwner)

- 属性：
  - `name` (String) - 车主姓名
  - `id` (int) - 身份证号
  - `car` (Car) - 拥有的汽车对象
- 方法：
  - `getName() : String` - 获取车主姓名
  - `getId() : int` - 获取身份证号
  - `buyCar(car: Car) : void` - 购买一辆汽车
  - `sellCar() : void` - 出售拥有的汽车

### 2.3 汽车类 (Car)

- 属性：
  - `manufacturer` (Manufacturer) - 制造商
  - `model` (String) - 型号
  - `color` (String) - 颜色
  - `year` (int) - 出厂年份
  - `isRegistered` (boolean) - 是否已注册
  - `owner` (CarOwner) - 汽车所有者
- 方法：
  - `getManufacturer() : Manufacturer` - 获取制造商
  - `getModel() : String` - 获取型号
  - `getColor() : String` - 获取颜色
  - `getYear() : int` - 获取出厂年份
  - `isRegistered() : boolean` - 是否已注册
  - `setRegistered(registered: boolean) : void` - 设置是否已注册
  - `getOwner() : CarOwner` - 获取汽车所有者
  - `setOwner(owner: CarOwner) : void` - 设置汽车所有者

### 2.4 交通管理机构类 (TrafficAuthority)

- 属性：
  - `name` (String) - 机构名称
  - `jurisdiction` (String) - 辖区
- 方法：
  - `getName() : String` - 获取机构名称
  - `getJurisdiction() : String` - 获取辖区
  - `registerCar(car: Car, owner: CarOwner) : void` - 注册一辆汽车
  - `deregisterCar(car: Car) : void` - 注销一辆汽车

### 2.5 主函数功能

创建厂家、车主和交通管理机构：

- 使用 `Manufacturer` 类创建一个厂家对象。
- 使用 `CarOwner` 类创建两个车主对象Bob和Jane。
- 在控制台中根据输入的车主姓名来选择相应的车主。

控制台交互：

- 使用一个无限循环来保持程序运行，直到用户选择退出。
- 在每次循环迭代中，显示菜单选项供用户选择。