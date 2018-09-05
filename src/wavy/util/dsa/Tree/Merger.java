package wavy.util.dsa.Tree;
/**
 * 融合器
 * Created by WavyPeng on 2018/09/05.
 */
public interface Merger<E> {
    E merge(E a,E b);
}