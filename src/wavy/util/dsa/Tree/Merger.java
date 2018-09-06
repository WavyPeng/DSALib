package wavy.util.dsa.Tree;
/**
 * 融合器（用于构建线段树节点）
 * Created by WavyPeng on 2018/09/05.
 */
public interface Merger<E> {
    E merge(E a,E b);
}