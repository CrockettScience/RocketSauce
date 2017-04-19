/*
 * Copyright (C) 2017 Jonathan Crockett
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.base.util.input;

public abstract class AbstractControlGraph<T extends AbstractControlGraph.CGNode> {
    
    private T current;

    public T getCurrent() {
        return current;
    }

    public void setCurrent(T current) {
        this.current = current;
    }
    
    public static class CGNode<T> {
        private T itemPointedAt;

        public T getItemPointedAt() {
            return itemPointedAt;
        }

        /**
         *
         * @param itemPointedAt
         */
        public void setItemPointedAt(T itemPointedAt) {
            this.itemPointedAt = itemPointedAt;
        }
    }
}
