import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<User> list1 = new ArrayList<>();


    }

    public List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public List<String> elList(List<User> userList){
        return userList.stream()
                .flatMap(a -> a.getSkills().stream())
                .toList();
    }

    public List<String> getAuthorsTitles(List<Book> books) {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .toList();
    }

    public List<String> flattenMap(Map<String, List<String>> map) {
        return map.values().stream()
                .flatMap(Collection::stream)
                .toList();

    }


    public List<Integer> processAndFilter(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .filter(el -> el%2==0)
                .map(el -> el*2)
                .toList();
    }

    public List<String> getLanguagesFromDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment()==department)
                .flatMap(employee -> employee.getLanguages().stream())
                .toList();
    }

    public List<Integer> flattenDeepListOfLists(List<List<List<Integer>>> deepList) {
    return deepList.stream()
            .flatMap(List::stream).flatMap(List::stream).toList();
    }

    public List<String> getSortedTasks(List<Project> projects) {
    return projects.stream()
            .filter(project -> project.getName()=="1")
            .flatMap(project -> project.getTasks().stream())
            .toList();
    }

    public List<String> getUniqueProductNames(Map<String, List<Product>> categoryMap) {
        return categoryMap.values().stream()
                .flatMap(List::stream)
                .map(Product::getName)
                .distinct()
                .toList();
    }

//    public List<Object> combineAndTransform(List<Integer> list1, List<Double> list2, Function<Number, String> transformer) {
//        return Stream.concat(list1.stream(),list2.stream())
//                .map(transformer)
//                .toList();
//    }  ????


    class Order {
        private String customerName;
        private List<Item> items;

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    class Item {
        private String name;
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public List<Item> getItemsByCustomerName(List<Order> orders, String customerName) {
        return orders.stream()
                .filter(order -> order.customerName == customerName)
                .flatMap(items -> items.items.stream())
                .toList();
    }

//    class Department {
//        private String name;
//        private List<Employee> employees;
//    }
//
//    class Employee {
//        private String name;
//        private double salary;
//    }

//    public double getTotalSalaryByDepartment(List<Department> departments, String departmentName) {
//        return departments.stream()
//                .filter(department -> department.name == departmentName)
//                .flatMap(department -> department.employees.stream())
//                .reduce(Double::sum);
//
//    } не понимаю почему не работает sum




    class Product {
        private String category;
        private String name;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Project {
        private String name;
        private List<String> tasks;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getTasks() {
            return tasks;
        }

        public void setTasks(List<String> tasks) {
            this.tasks = tasks;
        }
    }

    class Book {
        private String title;
        private List<String> authors;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }
    }

    class User {
        public static Stream<?> getSkills;
        private String name;
        private List<String> skills;

        public void setName(String name) {
            this.name = name;
        }

        public void setSkills(List<String> skills) {
            this.skills = skills;
        }

        public String getName() {
            return name;
        }

        public List<String> getSkills() {
            return skills;
        }
    }

    class Employee {
        private String department;
        private List<String> languages;

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public List<String> getLanguages() {
            return languages;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }
    }
}