#include <iostream>
#include <unordered_map>
#include <vector>
// Problem Link: https://open.kattis.com/contests/vm8cd3/problems/more10
typedef std::unordered_map<std::string, int> Dictionary;
typedef std::vector<std::pair<int, int>> Queries;
typedef std::string String;
typedef std::vector<std::pair<int,std::vector<std::pair<int,std::vector<int>>>>> Tree;
#define TREE_INIT 26, std::make_pair(-1, std::vector<std::pair<int,std::vector<int>>>(26, std::make_pair(-1, std::vector<int>(26,-1))))

// define a graph-like structure
struct Struc {
    std::vector<int> p; 
    Struc(int n) : p(n, -1) { }
    int root(int x) {
        while (p[x] >= 0) {
            if (p[p[x]] >= 0) p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }
    bool conn(int x, int y) {
        int xp = root(x), yp = root(y);
        if (xp == yp) return false;
        if (p[xp] > p[yp]) std::swap(xp,yp);
        p[xp] += p[yp], p[yp] = xp;
        return true; 
    }
    bool acc(int x, int y) {
        return root(x) == root(y);
    }
};

bool approve(Struc& uf, Queries& qq) {
    for (std::pair<int,int> x : qq) {
        if (uf.acc(x.first, x.second)) return false;
    }
    return true;
}
// rhyming case 1
void rr11(Struc& uf, Tree& tree, String& str, int i, int i1) {
    if (tree[i1].first == -1) {
        tree[i1].first = i;
        for (int i2 = 0; i2 < 26; i2++) {
            if (tree[i1].second[i2].first != -1) {
                uf.conn(i, tree[i1].second[i2].first);
            } else {
                for (int i3 = 0; i3 < 26; i3++) {
                    if (tree[i1].second[i2].second[i3] != -1) {
                        uf.conn(i, tree[i1].second[i2].second[i3]);
                    }
                }
            }
        }
    }
}
// rhyming case 2
void rr22(Struc& uf, Tree& tree, String& str, int i, int i1, int i2) {
    if (tree[i1].first != -1) {
        uf.conn(i, tree[i1].first);
    } else if (tree[i1].second[i2].first == -1) {
        tree[i1].second[i2].first = i;
        for (int i3 = 0; i3 < 26; i3++) {
            if (tree[i1].second[i2].second[i3] != -1) {
                uf.conn(i, tree[i1].second[i2].second[i3]);
            }
        }
    }
}
// rhyming case 3
void rr33(Struc& uf, Tree& tree, String& str, int i, int i1, int i2, int i3) {
    if (tree[i1].first != -1) {
        uf.conn(i, tree[i1].first);
    } else if (tree[i1].second[i2].first != -1) {
        uf.conn(i, tree[i1].second[i2].first);
    } else if (tree[i1].second[i2].second[i3] == -1) {
        tree[i1].second[i2].second[i3] = i;
    } else if (tree[i1].second[i2].second[i3] != i) {
        uf.conn(tree[i1].second[i2].second[i3],i);
    }
}
// test each rhyme case to see if it works
void art(Struc& uf, Tree& tree, String& str, int i) {
    switch (str.size()) {
        case 1:
            rr11(uf, tree, str, i, str[0]-'a');
            break;
        case 2:
            rr22(uf, tree, str, i, str[1]-'a', str[0]-'a');
            break;
        default:
            rr33(uf, tree, str, i, str[str.size()-1]-'a', str[str.size()-2]-'a', str[str.size()-3]-'a');
    }
}
// index of method to search
int iof(Dictionary& s2, String& str, int& nin) {
    int index;
    if (s2.find(str) == s2.end()) {
        index = nin++;
        s2[str] = index;
    } else {
        index = s2[str];
    }
    return index;
}
// bfs method (maybe)
void read(Struc& uf, Queries& qq, int n) {
    String a, b, op;
    int aa, bb, nin = 0;
    Dictionary s2;
    Tree tree(TREE_INIT);
    for (int i = 0; i < n; i++) {
        std::cin >> a >> op >> b;
        aa = iof(s2, a, nin);
        bb = iof(s2, b, nin);
        art(uf, tree, a, aa);
        art(uf, tree, b, bb);
        if (op[0] == 'n') qq.push_back(std::make_pair(aa, bb));
        else uf.conn(aa, bb);
    }
}

// input readers
void sc() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
}

int main() {
    // read input and print output
    sc();
    int n;
    std::cin >> n;
    Struc uf(n<<1);
    Queries qqq;
    read(uf, qqq, n);
    std::cout << (approve(uf, qqq) ? "yes\n" : "wait what?\n");
    return 0;
}
