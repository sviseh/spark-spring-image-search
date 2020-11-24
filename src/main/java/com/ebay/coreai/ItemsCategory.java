/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.ebay.coreai;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ItemsCategory extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1381564324531579702L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ItemsCategory\",\"namespace\":\"com.ebay.coreai\",\"fields\":[{\"name\":\"ItemsCategoryLookup\",\"type\":{\"type\":\"map\",\"values\":\"long\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ItemsCategory> ENCODER =
      new BinaryMessageEncoder<ItemsCategory>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ItemsCategory> DECODER =
      new BinaryMessageDecoder<ItemsCategory>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ItemsCategory> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ItemsCategory> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ItemsCategory> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ItemsCategory>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ItemsCategory to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ItemsCategory from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ItemsCategory instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ItemsCategory fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.util.Map<java.lang.CharSequence,java.lang.Long> ItemsCategoryLookup;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ItemsCategory() {}

  /**
   * All-args constructor.
   * @param ItemsCategoryLookup The new value for ItemsCategoryLookup
   */
  public ItemsCategory(java.util.Map<java.lang.CharSequence,java.lang.Long> ItemsCategoryLookup) {
    this.ItemsCategoryLookup = ItemsCategoryLookup;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ItemsCategoryLookup;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ItemsCategoryLookup = (java.util.Map<java.lang.CharSequence,java.lang.Long>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'ItemsCategoryLookup' field.
   * @return The value of the 'ItemsCategoryLookup' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.Long> getItemsCategoryLookup() {
    return ItemsCategoryLookup;
  }


  /**
   * Sets the value of the 'ItemsCategoryLookup' field.
   * @param value the value to set.
   */
  public void setItemsCategoryLookup(java.util.Map<java.lang.CharSequence,java.lang.Long> value) {
    this.ItemsCategoryLookup = value;
  }

  /**
   * Creates a new ItemsCategory RecordBuilder.
   * @return A new ItemsCategory RecordBuilder
   */
  public static com.ebay.coreai.ItemsCategory.Builder newBuilder() {
    return new com.ebay.coreai.ItemsCategory.Builder();
  }

  /**
   * Creates a new ItemsCategory RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ItemsCategory RecordBuilder
   */
  public static com.ebay.coreai.ItemsCategory.Builder newBuilder(com.ebay.coreai.ItemsCategory.Builder other) {
    if (other == null) {
      return new com.ebay.coreai.ItemsCategory.Builder();
    } else {
      return new com.ebay.coreai.ItemsCategory.Builder(other);
    }
  }

  /**
   * Creates a new ItemsCategory RecordBuilder by copying an existing ItemsCategory instance.
   * @param other The existing instance to copy.
   * @return A new ItemsCategory RecordBuilder
   */
  public static com.ebay.coreai.ItemsCategory.Builder newBuilder(com.ebay.coreai.ItemsCategory other) {
    if (other == null) {
      return new com.ebay.coreai.ItemsCategory.Builder();
    } else {
      return new com.ebay.coreai.ItemsCategory.Builder(other);
    }
  }

  /**
   * RecordBuilder for ItemsCategory instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ItemsCategory>
    implements org.apache.avro.data.RecordBuilder<ItemsCategory> {

    private java.util.Map<java.lang.CharSequence,java.lang.Long> ItemsCategoryLookup;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.ebay.coreai.ItemsCategory.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ItemsCategoryLookup)) {
        this.ItemsCategoryLookup = data().deepCopy(fields()[0].schema(), other.ItemsCategoryLookup);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing ItemsCategory instance
     * @param other The existing instance to copy.
     */
    private Builder(com.ebay.coreai.ItemsCategory other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.ItemsCategoryLookup)) {
        this.ItemsCategoryLookup = data().deepCopy(fields()[0].schema(), other.ItemsCategoryLookup);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'ItemsCategoryLookup' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.Long> getItemsCategoryLookup() {
      return ItemsCategoryLookup;
    }


    /**
      * Sets the value of the 'ItemsCategoryLookup' field.
      * @param value The value of 'ItemsCategoryLookup'.
      * @return This builder.
      */
    public com.ebay.coreai.ItemsCategory.Builder setItemsCategoryLookup(java.util.Map<java.lang.CharSequence,java.lang.Long> value) {
      validate(fields()[0], value);
      this.ItemsCategoryLookup = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'ItemsCategoryLookup' field has been set.
      * @return True if the 'ItemsCategoryLookup' field has been set, false otherwise.
      */
    public boolean hasItemsCategoryLookup() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ItemsCategoryLookup' field.
      * @return This builder.
      */
    public com.ebay.coreai.ItemsCategory.Builder clearItemsCategoryLookup() {
      ItemsCategoryLookup = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ItemsCategory build() {
      try {
        ItemsCategory record = new ItemsCategory();
        record.ItemsCategoryLookup = fieldSetFlags()[0] ? this.ItemsCategoryLookup : (java.util.Map<java.lang.CharSequence,java.lang.Long>) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ItemsCategory>
    WRITER$ = (org.apache.avro.io.DatumWriter<ItemsCategory>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ItemsCategory>
    READER$ = (org.apache.avro.io.DatumReader<ItemsCategory>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    long size0 = this.ItemsCategoryLookup.size();
    out.writeMapStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (java.util.Map.Entry<java.lang.CharSequence, java.lang.Long> e0: this.ItemsCategoryLookup.entrySet()) {
      actualSize0++;
      out.startItem();
      out.writeString(e0.getKey());
      java.lang.Long v0 = e0.getValue();
      out.writeLong(v0);
    }
    out.writeMapEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Map-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      long size0 = in.readMapStart();
      java.util.Map<java.lang.CharSequence,java.lang.Long> m0 = this.ItemsCategoryLookup; // Need fresh name due to limitation of macro system
      if (m0 == null) {
        m0 = new java.util.HashMap<java.lang.CharSequence,java.lang.Long>((int)size0);
        this.ItemsCategoryLookup = m0;
      } else m0.clear();
      for ( ; 0 < size0; size0 = in.mapNext()) {
        for ( ; size0 != 0; size0--) {
          java.lang.CharSequence k0 = null;
          k0 = in.readString(k0 instanceof Utf8 ? (Utf8)k0 : null);
          java.lang.Long v0 = null;
          v0 = in.readLong();
          m0.put(k0, v0);
        }
      }

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          long size0 = in.readMapStart();
          java.util.Map<java.lang.CharSequence,java.lang.Long> m0 = this.ItemsCategoryLookup; // Need fresh name due to limitation of macro system
          if (m0 == null) {
            m0 = new java.util.HashMap<java.lang.CharSequence,java.lang.Long>((int)size0);
            this.ItemsCategoryLookup = m0;
          } else m0.clear();
          for ( ; 0 < size0; size0 = in.mapNext()) {
            for ( ; size0 != 0; size0--) {
              java.lang.CharSequence k0 = null;
              k0 = in.readString(k0 instanceof Utf8 ? (Utf8)k0 : null);
              java.lang.Long v0 = null;
              v0 = in.readLong();
              m0.put(k0, v0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









