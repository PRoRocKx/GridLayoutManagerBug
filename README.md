# GridLayoutManagerBug
`onFocusSearchFailed()` called `getSpanGroupIndex()` with `viewPosition`(layoutPosition) argument.

`getSpanGroupIndex()` called `getCachedSpanGroupIndex()` with `viewPosition`(layoutPosition) argument.
```
        if (!state.isPreLayout()) {
            return mSpanSizeLookup.getCachedSpanGroupIndex(viewPosition, mSpanCount);
        }
```

`getCachedSpanGroupIndex()` called `getSpanGroupIndex()` with `viewPosition`(layoutPosition) argument but `getSpanGroupIndex()` work with adapterPosition argument:
```
* @param adapterPosition The position in adapter
public int getSpanGroupIndex(int adapterPosition, int spanCount)
```
