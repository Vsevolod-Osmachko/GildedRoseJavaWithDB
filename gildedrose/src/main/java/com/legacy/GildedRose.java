package com.legacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GildedRose {

    private Connection connection;

    PreparedStatement statement = null;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;

                        statement = null;
                        try {
                            statement = connection.prepareStatement("update store set quality = ? where name = ?");
                            statement.setInt(1, items[i].quality);
                            statement.setString(2, items[i].name);
                            statement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            if (connection != null) {
                                try {
                                    connection.rollback();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } finally {
                            if (statement != null) {
                                try {
                                    statement.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    statement = null;
                    try {
                        statement = connection.prepareStatement("update store set quality = ? where name = ?");
                        statement.setInt(1, items[i].quality);
                        statement.setString(2, items[i].name);
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        if (connection != null) {
                            try {
                                connection.rollback();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } finally {
                        if (statement != null) {
                            try {
                                statement.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;

                                statement = null;
                                try {
                                    statement = connection.prepareStatement("update store set quality = ? where name = ?");
                                    statement.setInt(1, items[i].quality);
                                    statement.setString(2, items[i].name);
                                    statement.executeUpdate();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    if (connection != null) {
                                        try {
                                            connection.rollback();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                } finally {
                                    if (statement != null) {
                                        try {
                                            statement.close();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }


                                PreparedStatement statement = null;
                                try {
                                    statement = connection.prepareStatement("update store set quality = ? where name = ?");
                                    statement.setInt(1, items[i].quality);
                                    statement.setString(2, items[i].name);
                                    statement.executeUpdate();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    if (connection != null) {
                                        try {
                                            connection.rollback();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                } finally {
                                    if (statement != null) {
                                        try {
                                            statement.close();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;

                                statement = null;
                                try {
                                    statement = connection.prepareStatement("update store set quality = ? where name = ?");
                                    statement.setInt(1, items[i].quality);
                                    statement.setString(2, items[i].name);
                                    statement.executeUpdate();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    if (connection != null) {
                                        try {
                                            connection.rollback();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                } finally {
                                    if (statement != null) {
                                        try {
                                            statement.close();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;

                statement = null;
                try {
                    statement = connection.prepareStatement("update store set sellIn = ? where name = ?");
                    statement.setInt(1, items[i].sellIn);
                    statement.setString(2, items[i].name);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    if (connection != null) {
                        try {
                            connection.rollback();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;

                                statement = null;
                                try {
                                    statement = connection.prepareStatement("update store set quality = ? where name = ?");
                                    statement.setInt(1, items[i].quality);
                                    statement.setString(2, items[i].name);
                                    statement.executeUpdate();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    if (connection != null) {
                                        try {
                                            connection.rollback();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                } finally {
                                    if (statement != null) {
                                        try {
                                            statement.close();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;

                        statement = null;
                        try {
                            statement = connection.prepareStatement("update store set quality = ? where name = ?");
                            statement.setInt(1, items[i].quality);
                            statement.setString(2, items[i].name);
                            statement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            if (connection != null) {
                                try {
                                    connection.rollback();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } finally {
                            if (statement != null) {
                                try {
                                    statement.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;

                        statement = null;
                        try {
                            statement = connection.prepareStatement("update store set quality = ? where name = ?");
                            statement.setInt(1, items[i].quality);
                            statement.setString(2, items[i].name);
                            statement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            if (connection != null) {
                                try {
                                    connection.rollback();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } finally {
                            if (statement != null) {
                                try {
                                    statement.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}