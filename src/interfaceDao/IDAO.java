package interfaceDao;

import java.util.List;

public interface IDAO<T, I> {
    public void insert(T data);
    public List<T> showData(I data);
    public void update(T data, I data2);
    public void delete(I data);
    public T search(I data);
}
