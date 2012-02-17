/*     */ package org.hi.studio.hsceditor.visual.editpart;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.eclipse.draw2d.AbstractRouter;
/*     */ import org.eclipse.draw2d.Connection;
/*     */ import org.eclipse.draw2d.ConnectionAnchor;
/*     */ import org.eclipse.draw2d.IFigure;
/*     */ import org.eclipse.draw2d.geometry.Point;
/*     */ import org.eclipse.draw2d.geometry.PointList;
/*     */ import org.eclipse.draw2d.geometry.Ray;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ 
/*     */ public class ManhattanConnectionRouter extends AbstractRouter
/*     */ {
/*  24 */   private Map rowsUsed = new HashMap();
/*  25 */   private Map colsUsed = new HashMap();
/*     */ 
/*  28 */   private Map reservedInfo = new HashMap();
/*     */ 
/*  35 */   private static Ray UP = new Ray(0, -1);
/*  36 */   private static Ray DOWN = new Ray(0, 1);
/*  37 */   private static Ray LEFT = new Ray(-1, 0);
/*  38 */   private static Ray RIGHT = new Ray(1, 0);
/*     */ 
/*  40 */   private int duplicationCount = 0;
/*  41 */   private int interval = 20;
/*     */ 
/*     */   public void setInterval(int interval) {
/*  44 */     this.interval = interval;
/*     */   }
/*     */ 
/*     */   public void setDuplicationCount(int duplicationCount) {
/*  48 */     this.duplicationCount = duplicationCount;
/*     */   }
/*     */ 
/*     */   public void invalidate(Connection connection)
/*     */   {
/*  55 */     removeReservedLines(connection);
/*     */   }
/*     */ 
/*     */   private int getColumnNear(Connection connection, int r, int n, int x) {
/*  59 */     int min = Math.min(n, x);
/*  60 */     int max = Math.max(n, x);
/*  61 */     if (min > r) {
/*  62 */       max = min;
/*  63 */       min = r - (min - r);
/*     */     }
/*  65 */     if (max < r) {
/*  66 */       min = max;
/*  67 */       max = r + (r - max);
/*     */     }
/*  69 */     int proximity = 0;
/*  70 */     int direction = -1;
/*  71 */     if (r % 2 == 1) {
/*  72 */       r--;
/*     */     }
/*  74 */     while (proximity < r) {
/*  75 */       Integer i = new Integer(r + proximity * direction);
/*  76 */       if (!this.colsUsed.containsKey(i)) {
/*  77 */         this.colsUsed.put(i, i);
/*  78 */         reserveColumn(connection, i);
/*  79 */         return i.intValue();
/*     */       }
/*  81 */       int j = i.intValue();
/*  82 */       if (j <= min)
/*  83 */         return j + 2;
/*  84 */       if (j >= max)
/*  85 */         return j - 2;
/*  86 */       if (direction == 1) {
/*  87 */         direction = -1;
/*     */       } else {
/*  89 */         direction = 1;
/*  90 */         proximity += 2;
/*     */       }
/*     */     }
/*  93 */     return r;
/*     */   }
/*     */ 
/*     */   protected Ray getDirection(Rectangle r, Point p)
/*     */   {
/* 105 */     int distance = Math.abs(r.x - p.x);
/*     */ 
/* 108 */     Ray direction = LEFT;
/*     */ 
/* 110 */     int i = Math.abs(r.y - p.y);
/* 111 */     if (i <= distance) {
/* 112 */       distance = i;
/* 113 */       direction = UP;
/*     */     }
/*     */ 
/* 116 */     i = Math.abs(r.bottom() - p.y);
/* 117 */     if (i <= distance) {
/* 118 */       distance = i;
/* 119 */       direction = DOWN;
/*     */     }
/*     */ 
/* 122 */     i = Math.abs(r.right() - p.x);
/* 123 */     if (i < distance) {
/* 124 */       distance = i;
/* 125 */       direction = RIGHT;
/*     */     }
/*     */ 
/* 128 */     return direction;
/*     */   }
/*     */ 
/*     */   protected Ray getEndDirection(Connection conn) {
/* 132 */     ConnectionAnchor anchor = conn.getTargetAnchor();
/* 133 */     Point p = getEndPoint(conn);
/*     */     Rectangle rect;
/*     */     Rectangle rect;
/* 135 */     if (anchor.getOwner() == null) {
/* 136 */       rect = new Rectangle(p.x - 1, p.y - 1, 2, 2);
/*     */     } else {
/* 138 */       rect = conn.getTargetAnchor().getOwner().getBounds().getCopy();
/* 139 */       conn.getTargetAnchor().getOwner().translateToAbsolute(rect);
/*     */     }
/* 141 */     return getDirection(rect, p);
/*     */   }
/*     */ 
/*     */   protected int getRowNear(Connection connection, int r, int n, int x) {
/* 145 */     int min = Math.min(n, x);
/* 146 */     int max = Math.max(n, x);
/* 147 */     if (min > r) {
/* 148 */       max = min;
/* 149 */       min = r - (min - r);
/*     */     }
/* 151 */     if (max < r) {
/* 152 */       min = max;
/* 153 */       max = r + (r - max);
/*     */     }
/*     */ 
/* 156 */     int proximity = 0;
/* 157 */     int direction = -1;
/* 158 */     if (r % 2 == 1) {
/* 159 */       r--;
/*     */     }
/* 161 */     while (proximity < r) {
/* 162 */       Integer i = new Integer(r + proximity * direction);
/* 163 */       if (!this.rowsUsed.containsKey(i)) {
/* 164 */         this.rowsUsed.put(i, i);
/* 165 */         reserveRow(connection, i);
/* 166 */         return i.intValue();
/*     */       }
/* 168 */       int j = i.intValue();
/* 169 */       if (j <= min)
/* 170 */         return j + 2;
/* 171 */       if (j >= max)
/* 172 */         return j - 2;
/* 173 */       if (direction == 1) {
/* 174 */         direction = -1;
/*     */       } else {
/* 176 */         direction = 1;
/* 177 */         proximity += 2;
/*     */       }
/*     */     }
/* 180 */     return r;
/*     */   }
/*     */ 
/*     */   protected Ray getStartDirection(Connection conn) {
/* 184 */     ConnectionAnchor anchor = conn.getSourceAnchor();
/* 185 */     Point p = getStartPoint(conn);
/*     */     Rectangle rect;
/*     */     Rectangle rect;
/* 187 */     if (anchor.getOwner() == null) {
/* 188 */       rect = new Rectangle(p.x - 1, p.y - 1, 2, 2);
/*     */     } else {
/* 190 */       rect = conn.getSourceAnchor().getOwner().getBounds().getCopy();
/* 191 */       conn.getSourceAnchor().getOwner().translateToAbsolute(rect);
/*     */     }
/* 193 */     return getDirection(rect, p);
/*     */   }
/*     */ 
/*     */   protected void processPositions(Ray start, Ray end, List positions, boolean horizontal, Connection conn)
/*     */   {
/* 198 */     removeReservedLines(conn);
/*     */ 
/* 200 */     int[] pos = new int[positions.size() + 2];
/* 201 */     if (horizontal)
/* 202 */       pos[0] = start.x;
/*     */     else {
/* 204 */       pos[0] = start.y;
/*     */     }
/* 206 */     for (int i = 0; i < positions.size(); i++) {
/* 207 */       pos[(i + 1)] = ((Integer)positions.get(i)).intValue();
/*     */     }
/* 209 */     if (horizontal == (positions.size() % 2 == 1)) {
/* 210 */       i++; pos[i] = end.x;
/*     */     } else {
/* 212 */       i++; pos[i] = end.y;
/*     */     }
/* 214 */     PointList points = new PointList();
/* 215 */     points.addPoint(new Point(start.x, start.y));
/*     */ 
/* 219 */     for (i = 2; i < pos.length - 1; i++) {
/* 220 */       horizontal = !horizontal;
/* 221 */       int prev = pos[(i - 1)];
/* 222 */       int current = pos[i];
/*     */ 
/* 224 */       boolean adjust = i != pos.length - 2;
/*     */       Point p;
/*     */       Point p;
/* 225 */       if (horizontal) {
/* 226 */         if (adjust) {
/* 227 */           int min = pos[(i - 2)];
/* 228 */           int max = pos[(i + 2)];
/*     */           int tmp256_253 = getRowNear(conn, current, min, max); current = tmp256_253; pos[i] = tmp256_253;
/*     */         }
/* 231 */         p = new Point(prev, current);
/*     */       } else {
/* 233 */         if (adjust) {
/* 234 */           int min = pos[(i - 2)];
/* 235 */           int max = pos[(i + 2)];
/*     */           int tmp315_312 = getColumnNear(conn, current, min, max); current = tmp315_312; pos[i] = tmp315_312;
/*     */         }
/* 238 */         p = new Point(current, prev);
/*     */       }
/* 240 */       points.addPoint(p);
/*     */     }
/* 242 */     points.addPoint(new Point(end.x, end.y));
/* 243 */     conn.setPoints(points);
/*     */   }
/*     */ 
/*     */   public void remove(Connection connection)
/*     */   {
/* 250 */     removeReservedLines(connection);
/*     */   }
/*     */ 
/*     */   protected void removeReservedLines(Connection connection) {
/* 254 */     ReservedInfo rInfo = (ReservedInfo)this.reservedInfo.get(connection);
/* 255 */     if (rInfo == null) {
/* 256 */       return;
/*     */     }
/* 258 */     for (int i = 0; i < rInfo.reservedRows.size(); i++) {
/* 259 */       this.rowsUsed.remove(rInfo.reservedRows.get(i));
/*     */     }
/* 261 */     for (int i = 0; i < rInfo.reservedCols.size(); i++) {
/* 262 */       this.colsUsed.remove(rInfo.reservedCols.get(i));
/*     */     }
/* 264 */     this.reservedInfo.remove(connection);
/*     */   }
/*     */ 
/*     */   protected void reserveColumn(Connection connection, Integer column) {
/* 268 */     ReservedInfo info = (ReservedInfo)this.reservedInfo.get(connection);
/* 269 */     if (info == null) {
/* 270 */       info = new ReservedInfo(null);
/* 271 */       this.reservedInfo.put(connection, info);
/*     */     }
/* 273 */     info.reservedCols.add(column);
/*     */   }
/*     */ 
/*     */   protected void reserveRow(Connection connection, Integer row) {
/* 277 */     ReservedInfo info = (ReservedInfo)this.reservedInfo.get(connection);
/* 278 */     if (info == null) {
/* 279 */       info = new ReservedInfo(null);
/* 280 */       this.reservedInfo.put(connection, info);
/*     */     }
/* 282 */     info.reservedRows.add(row);
/*     */   }
/*     */ 
/*     */   public void route(Connection conn)
/*     */   {
/* 289 */     if ((conn.getSourceAnchor() == null) || (conn.getTargetAnchor() == null)) {
/* 290 */       return;
/*     */     }
/*     */ 
/* 294 */     Point startPoint = getStartPoint(conn);
/* 295 */     conn.translateToRelative(startPoint);
/* 296 */     Point endPoint = getEndPoint(conn);
/* 297 */     conn.translateToRelative(endPoint);
/*     */ 
/* 299 */     Ray start = new Ray(startPoint);
/* 300 */     Ray end = new Ray(endPoint);
/* 301 */     Ray average = start.getAveraged(end);
/*     */ 
/* 303 */     Ray startNormal = getStartDirection(conn);
/* 304 */     Ray endNormal = getEndDirection(conn);
/* 305 */     Ray direction = new Ray(start, end);
/*     */ 
/* 307 */     boolean horizontal = startNormal.isHorizontal();
/*     */ 
/* 309 */     if (horizontal) {
/* 310 */       start.y += this.duplicationCount * this.interval;
/* 311 */       end.y += this.duplicationCount * this.interval;
/*     */     } else {
/* 313 */       start.x += this.duplicationCount * this.interval;
/* 314 */       end.x += this.duplicationCount * this.interval;
/*     */     }
/*     */ 
/* 317 */     List positions = new ArrayList(5);
/* 318 */     if (horizontal)
/* 319 */       positions.add(new Integer(start.y));
/*     */     else
/* 321 */       positions.add(new Integer(start.x));
/* 322 */     horizontal = !horizontal;
/*     */ 
/* 324 */     if (startNormal.dotProduct(endNormal) == 0) {
/* 325 */       if ((startNormal.dotProduct(direction) < 0) || 
/* 326 */         (endNormal.dotProduct(direction) > 0))
/*     */       {
/*     */         int i;
/*     */         int i;
/* 330 */         if (startNormal.dotProduct(direction) < 0) {
/* 331 */           i = startNormal.similarity(start.getAdded(startNormal.getScaled(10)));
/*     */         }
/*     */         else
/*     */         {
/*     */           int i;
/* 333 */           if (horizontal)
/* 334 */             i = average.y;
/*     */           else
/* 336 */             i = average.x;
/*     */         }
/* 338 */         positions.add(new Integer(i));
/* 339 */         horizontal = !horizontal;
/*     */ 
/* 341 */         if (endNormal.dotProduct(direction) > 0) {
/* 342 */           i = endNormal.similarity(end.getAdded(endNormal.getScaled(10)));
/*     */         }
/* 344 */         else if (horizontal)
/* 345 */           i = average.y;
/*     */         else {
/* 347 */           i = average.x;
/*     */         }
/* 349 */         positions.add(new Integer(i + this.duplicationCount * this.interval));
/* 350 */         horizontal = !horizontal;
/*     */       }
/*     */     }
/* 353 */     else if (startNormal.dotProduct(endNormal) > 0)
/*     */     {
/*     */       int i;
/*     */       int i;
/* 355 */       if (startNormal.dotProduct(direction) >= 0)
/* 356 */         i = startNormal.similarity(start.getAdded(startNormal.getScaled(10)));
/*     */       else
/* 358 */         i = endNormal.similarity(end.getAdded(endNormal.getScaled(10)));
/* 359 */       positions.add(new Integer(i + this.duplicationCount * this.interval));
/* 360 */       horizontal = !horizontal;
/*     */     }
/*     */     else {
/* 363 */       if (startNormal.dotProduct(direction) < 0) {
/* 364 */         int i = startNormal.similarity(start.getAdded(startNormal.getScaled(10)));
/* 365 */         positions.add(new Integer(i + this.duplicationCount * this.interval));
/* 366 */         horizontal = !horizontal;
/*     */       }
/*     */       int i;
/*     */       int i;
/* 369 */       if (horizontal)
/* 370 */         i = average.y;
/*     */       else
/* 372 */         i = average.x;
/* 373 */       positions.add(new Integer(i + this.duplicationCount * this.interval));
/* 374 */       horizontal = !horizontal;
/*     */ 
/* 376 */       if (startNormal.dotProduct(direction) < 0) {
/* 377 */         i = endNormal.similarity(end.getAdded(endNormal.getScaled(10)));
/* 378 */         positions.add(new Integer(i + this.duplicationCount * this.interval));
/* 379 */         horizontal = !horizontal;
/*     */       }
/*     */     }
/*     */ 
/* 383 */     if (horizontal)
/* 384 */       positions.add(new Integer(end.y));
/*     */     else {
/* 386 */       positions.add(new Integer(end.x));
/*     */     }
/* 388 */     processPositions(start, end, positions, startNormal.isHorizontal(), conn);
/*     */   }
/*     */ 
/*     */   private class ReservedInfo
/*     */   {
/*  31 */     public List reservedRows = new ArrayList(2);
/*  32 */     public List reservedCols = new ArrayList(2);
/*     */ 
/*     */     private ReservedInfo()
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.ManhattanConnectionRouter
 * JD-Core Version:    0.6.0
 */